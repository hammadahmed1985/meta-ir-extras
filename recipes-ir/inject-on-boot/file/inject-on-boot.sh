#!/bin/sh

timerinputme &
cd /usr/bindings/USBProxy/src/tools/ && python3 buttonsme &
cd /usr/bindings/USBProxy/src/bindings/python && ./usbproxy-fd-keyboard.py
