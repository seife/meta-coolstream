# Coolstream HD1 BSP default settings

IMAGE_CLASSES += "usb_image-hd1"
JFFS2_ERASEBLOCK = "0x20000"
JFFS2_SUM_EXTRA_ARGS = "-p -e 0x20000"
EXTRA_IMAGECMD_jffs2 = "-p -U --cleanmarker=12"
