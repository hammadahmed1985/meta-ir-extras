#!/bin/bash

kill -9 $(pidof connmand)
udhcpc -i eth0 > /dev/null&

next_evdev="$(( $(ls /dev/input/event* | wc -l) ))"
timerinputme &
sleep 2
evdev-usb-bridge /dev/input/event${next_evdev} &

python3 $(which buttonsme) &
cd /usr/bindings/python/USBProxy && ./usbproxy-fd-keyboard.py &

sleep 3
export DISPLAY=:0
/usr/bin/infotainment_demo &

