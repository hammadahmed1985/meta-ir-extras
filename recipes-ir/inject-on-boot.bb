
DESCRIPTION = "Startup script that starts USBProxy on boot " 
BUGTRACKER = "http://bugzilla.yoctoproject.org/"
PR = "r0"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://inject-on-boot.sh;md5=1484b9683e3fc1dd9f5cf802a23fe67c"

SRC_URI = "file://inject-on-boot.sh"

do_install(){
  # Create directories:
  #   ${D}${sysconfdir}/init.d - will hold the scripts
  #   ${D}${sysconfdir}/rcS.d  - will contain a link to the script that runs at startup
  #   ${D}${sysconfdir}/rc5.d  - will contain a link to the script that runs at runlevel=5
  #   ${D}${sbindir}           - scripts called by the above
  #
  # ${D} is effectively the root directory of the target system.
  # ${D}${sysconfdir} is where system configuration files are to be stored (e.g. /etc).
  # ${D}${sbindir} is where executable files are to be stored (e.g. /sbin).
  #
  install -d ${D}${sysconfdir}/init.d
  install -d ${D}${sysconfdir}/rcS.d
  install -d ${D}${sysconfdir}/rc1.d
  install -d ${D}${sysconfdir}/rc2.d
  install -d ${D}${sysconfdir}/rc3.d
  install -d ${D}${sysconfdir}/rc4.d
  install -d ${D}${sysconfdir}/rc5.dll() {

  install -m 0755 ${WORKDIR}/inject-on-boot.sh  ${D}${sysconfdir}/init.d/
  ln -sf ../init.d/inject-on-boot.sh  ${D}${sysconfdir}/rcS.d/S90inject-on-boot.sh
  
  
}
