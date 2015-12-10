
DESCRIPTION = "Startup script that starts USBProxy on boot " 
BUGTRACKER = "http://bugzilla.yoctoproject.org/"
PR = "r0"

# Runtime dependencies
#
# Add a line similar to the following to ensure any packages needed for the scripts to run are installed in the image.
#
# RDEPENDS_${PN} = "parted"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://${WORKDIR}/inject-on-boot.sh;md5=d9f5cf5a12902c90c903d9817fadfddb"

SRC_URI = "file://inject-on-boot.sh file://11-evdev-excludes.conf"

do_install () {
    #
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
    install -d ${D}${sysconfdir}/rc5.d

    #
    # Install files in to the image
    #
    # The files fetched via SRC_URI (above) will be in ${WORKDIR}.
    #
    install -m 0755 ${WORKDIR}/inject-on-boot.sh ${D}${sysconfdir}/init.d/


    #
    # Create symbolic links from the runlevel directories to the script files.
    # Links of the form S... and K... mean the script when be called when
    # entering / exiting the runlevel designated by the containing directory.
    # For example:
    #   rc5.d/S90run-script will be called (with %1='start') when entering runlevel 5.
    #   rc5.d/K90run-script will be called (with %1='stop') when exiting runlevel 5.
    #
    ln -sf ../init.d/inject-on-boot.sh  ${D}${sysconfdir}/rc5.d/S90inject-on-boot.sh


    install -m 0755 -d ${D}${datadir}/X11/xorg.conf.d
    install -m 0644 ${WORKDIR}/11-evdev-excludes.conf ${D}${datadir}/X11/xorg.conf.d/
}

FILES_${PN} += "${datadir}/X11/xorg.conf.d/*"

