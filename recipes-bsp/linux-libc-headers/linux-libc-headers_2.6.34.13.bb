require linux-libc-headers.inc

SRC_URI = " \
	http://www.kernel.org/pub/linux/kernel/v2.6/longterm/v2.6.34/linux-2.6.34.13.tar.xz \
	file://0001-ARM-6329-1-wire-up-sys_accept4-on-ARM.patch\
"

SRC_URI[md5sum] = "ec72935604c58d26b044e0cb2a496a3b"
SRC_URI[sha256sum] = "cb50a9ec2e24fb0d02eb4983e5c7bc61725cdcf212813a79121a0bb12ac0b4ce"
