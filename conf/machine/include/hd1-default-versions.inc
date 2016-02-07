# Coolstream HD1 BSP default versions

# "upstream" seems to use 4.6.3, so let's avoid gcc 5.x for now
GCCVERSION ?= "4.9%"

# currently usable kernel version, use the same for headers
LINUXLIBCVERSION ?= "2.6.34%"
