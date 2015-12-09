#!/bin/bash

udhcpc -i eth0 &
export DISPLAY=:0
/usr/bin/infotainment_demo &

next_evdev="$(( $(ls /dev/input/event* | wc -l) + 1 ))"
timerinputme &
evdev-usb-bridge /dev/input/event${next_evdev} &

cd /usr/bindings/USBProxy/src/tools/ && python3 buttonsme &
cd /usr/bindings/USBProxy/src/bindings/python && ./usbproxy-fd-keyboard.py

