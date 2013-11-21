#!/bin/bash
#
# copy this into your build directory to test your image...
#
if test -z "$1"; then
	set -- --append "console=ttyRI0 root=/dev/mmcblk0" -sd neutrino-image-coolstream.ext3
fi
cd tmp/deploy/images/coolstream
qemu-system-arm -m 256 -serial stdio -no-reboot \
	-cpu arm1176 -M versatilepb \
	-kernel zImage-qemu-coolstream.bin \
	"$@"
