#!/bin/bash

link_state() {
    ethtool eth0 | grep -q "Link detected: yes"
}

if link_state; then
    PREV_LINK_UP=true
else
    PREV_LINK_UP=false
fi

while true; do
    if link_state; then
        LINK_UP=true
    else
        LINK_UP=false
    fi

    if [ "$LINK_UP" == "true" ] && [ "$PREV_LINK_UP" != "$LINK_UP" ]; then
        kill -USR1 $(pidof udhcpc)
    fi

    PREV_LINK_UP="$LINK_UP"
    sleep 3
done
