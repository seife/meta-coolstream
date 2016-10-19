FILESEXTRAPATHS_prepend := "${THISDIR}/udev-extraconf:"

### old kernel needs userspace firmware loader...
###
### set PACKAGE_ARCH to MACHINE_ARCH, because other machines
### with this arch might have newer kernels and not need this
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI += " \
	file://firmware.sh \
	file://50-firmware-userspace.rules \
"

do_install_append() {
	install -D -m 0755 ${WORKDIR}/firmware.sh ${D}/etc/udev/scripts/firmware.sh
	install -D -m 0644 ${WORKDIR}/50-firmware-userspace.rules ${D}/etc/udev/rules.d/50-firmware-userspace.rules
}
