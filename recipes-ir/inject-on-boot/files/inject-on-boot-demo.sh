#!/bin/bash

kill -9 $(pidof connmand)
udhcpc -i eth0 &

python3 $(which buttonsme) &

