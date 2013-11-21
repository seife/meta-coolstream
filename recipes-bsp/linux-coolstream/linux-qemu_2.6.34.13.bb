require linux.inc

DEPENDS += "xz-native"

DESCRIPTION = "Linux kernel for qemu-booting the Coolstream HD1 image"
COMPATIBLE_MACHINE = "coolstream"

PR = "r0"

SRC_URI = "http://www.kernel.org/pub/linux/kernel/v2.6/longterm/v2.6.34/linux-2.6.34.13.tar.xz \
	file://0001-ARM-6329-1-wire-up-sys_accept4-on-ARM.patch \
	file://linux-2.6.34.13-arm-versatile-with-1176.patch \
	file://linux-2.6.34.13-rename-ttyAMA-to-ttyRI.patch \
	file://defconfig \
"

S = "${WORKDIR}/linux-${PV}"
KV = "${PV}-nevis"

# NOTE: For now we pull in the default config from the RPi kernel GIT tree.
KERNEL_DEFCONFIG = "defconfig"

# CMDLINE for Coolstream is set by U-Boot.
CMDLINE_coolstream = ""

UDEV_GE_141 ?= "1"

do_configure_prepend() {
	cp '${WORKDIR}/defconfig' '${S}/.config'
}

PACKAGES = ""
PROVIDES = ""
RPROVIDES = ""

do_compile_kernelmodules() {
}

do_package() {
}

do_populate_sysroot() {
}

do_deploy() {
        install -m 0644 arch/arm/boot/zImage ${DEPLOYDIR}/zImage-qemu-coolstream.bin
}

#do_deploy_setscene()
#do_package_setscene()
#do_bundle_initramfs
#do_clean
#do_package_write_ipk_setscene
#do_package_write_rpm_setscene
#do_package_write
#do_package_write_rpm
#do_packagedata
#do_packagedata_setscene
#do_populate_sysroot_setscene
#do_rm_work_all
#do_sizecheck
