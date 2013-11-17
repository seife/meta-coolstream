DESCRIPTION = "Hardware drivers & libs for Coolstream HD1"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://license;md5=17a6b3d5436a55985b200c725761907a"

COMPATIBLE_MACHINE = "coolstream"
# kernel modules are generally machine specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

# inherit module

Pn = "r0"

PROVIDES += "virtual/stb-hal-libs"

KV = "2.6.34.13"
KV_FULL = "${KV}-nevis"
SRCREV = "${AUTOREV}"
PV = "0.0+git${SRCPV}"

SRC_URI = " \
	git://c00lstreamtech.de/cst-public-drivers.git \
	file://license \
"

S = "${WORKDIR}/git"

# The compiled binaries don't provide sonames.
SOLIBS = "${SOLIBSDEV}"

# These are proprietary binaries generated elsewhere so don't check ldflags
INSANE_SKIP_${PN} = "ldflags already-stripped"
INSANE_SKIP_${PN}-dev = "ldflags"

# no idea why do_configure does not find the license file otherwise...
do_configure_prepend () {
	cp '${WORKDIR}/license' '${S}'
}

do_compile () {
}

do_install () {
	install -d ${D}/lib/modules/${KV_FULL}/extra
	pushd nevis/drivers/${KV_FULL}
	for i in *; do
		case $i in
		block2mtd.ko|cifs.ko|ftdi-sio.ko|fuse.ko|mtdram.ko|pl2303.ko|rt2870sta.ko|usbserial.ko)
			;;
		*)
			cp $i ${D}/lib/modules/${KV_FULL}/extra ;;
		esac
	done
	popd
	# install -d ${D}${libdir}
	install -d ${D}/lib/firmware
	cp -R nevis/libs/* ${D}/lib/
	cp -R nevis/firmware/* ${D}/lib/firmware
}

FILES_${PN} = " \
	/lib/libca-sc.so \
	/lib/libcoolstream-mt.so \
	/lib/libnxp.so \
	/lib/firmware/ \
	/lib/modules/ \
"

# do not put the *.so into -dev package
FILES_${PN}-dev = ""
