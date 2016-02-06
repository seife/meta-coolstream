## hack, to build new libcap with old kernel headers.
## old libcap had those included...
do_configure_prepend() {
	if [ `expr ${PV} \> 2.22` = 1 ]; then
		rm -f ${S}/libcap/include/linux/capability.h
		rm -f ${S}/libcap/include/uapi/linux/capability.h
		ln -s ${STAGING_INCDIR}/linux/capability.h ${S}/libcap/include/linux/capability.h
		ln -s ../../linux/capability.h ${S}/libcap/include/uapi/linux/capability.h
	fi
}
