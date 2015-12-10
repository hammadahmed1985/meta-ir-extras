DESCRIPTION = "A Qt-based fake infotainment screen " 
PR = "r0"

LICENSE = "CLOSED"

DEPENDS = "qtbase qtquick1"
inherit qmake5

PV = "0.1+gitr${SRCPV}"
SRCREV = "${AUTOREV}"

SRC_URI = "git://scm-core.ott.dev.intra/automotive-demo;branch=master"

S = "${WORKDIR}/git/infotainment_demo"

inherit pkgconfig

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${WORKDIR}/build/infotainment_demo ${D}/${bindir}
}
