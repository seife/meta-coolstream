# hack to fix build with jethro and old kernel headers
do_configure_prepend() {
	rm -f ${S}/linux/linux
	ln -s . ${S}/linux/linux
}
