#!/bin/bash

udhcpc -i eth0 &

export DISPLAY=:0
/usr/bin/infotainment_demo &

next_evdev="$(( $(ls /dev/input/event* | wc -l) + 1 ))"
timerinputme &
evdev-usb-bridge /dev/input/event${next_evdev} &

python3 $(which buttonsme) &
cd /usr/bindings/python/USBProxy && ./usbproxy-fd-keyboard.py &

