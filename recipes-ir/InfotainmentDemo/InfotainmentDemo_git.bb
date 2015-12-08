DESCRIPTION = "A Qt-based fake infotainment screen " 
PR = "r0"

LICENSE = "CLOSED"

DEPENDS = "qtbase qtquick1"
inherit qmake5

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/Anteros78/infotainment_demo.git;branch=master"

S = "${WORKDIR}/git"

inherit pkgconfig

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${WORKDIR}/build/infotainment_demo ${D}/${bindir}
}
