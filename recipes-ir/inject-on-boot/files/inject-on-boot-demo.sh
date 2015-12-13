#!/bin/bash

kill -9 $(pidof udhcpc)

python3 -B $(which buttonsme) &

