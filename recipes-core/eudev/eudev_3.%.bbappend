FILESEXTRAPATHS_append := ":${THISDIR}/eudev"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI += " \
    file://eudev-oldkernel.patch \
    file://eudev-builtin-input_id.patch \
"

