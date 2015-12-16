#!/bin/bash

if [ -e /dev/ttyACM0 ]
  then
    python3 -B $(which buttonsme) &
    sleep 15
    echo "Turning on box lights for Demo"
    echo -en '\xAD' > /dev/ttyACM0
    echo -en '\x2D' > /dev/ttyACM0
fi

