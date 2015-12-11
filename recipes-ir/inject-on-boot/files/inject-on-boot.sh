#!/bin/bash

kill -9 $(pidof connmand)
kill -9 $(pidof udhcpc)
udhcpc -i eth0 &
/etc/init.d/renew-on-up.sh &

next_evdev="$(( $(ls /dev/input/event* | wc -l) ))"
timerinputme &
sleep 2
evdev-usb-bridge /dev/input/event${next_evdev} &

python3 $(which buttonsme) &
sleep 2
cd /usr/bindings/python/USBProxy && ./usbproxy-fd-keyboard.py &

sleep 3
export DISPLAY=:0
xrandr -o inverted
xinput set-int-prop "fusion Touch Screen" "Evdev Axis Inversion" 8 1 1
/usr/bin/infotainment_demo &

