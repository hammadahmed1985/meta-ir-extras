
DESCRIPTION = "Startup script that starts USBProxy on boot " 
BUGTRACKER = "http://bugzilla.yoctoproject.org/"
PR = "r0"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1484b9683e3fc1dd9f5cf802a23fe67c"

SRC_URI = "file://inject-on-boot.sh"

do_install() {
  install -m 0755 ${WORKDIR}/inject-on-boot.sh  ${D}${sysconfdir}/init.d/
}
