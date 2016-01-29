#!/bin/bash
URL='https://hu.wikipedia.org/wiki/Magyar_n%C3%A9vnapok_bet%C5%B1rendben'
WIKI='wiki'
# wget "$URL" -O "$WIKI"
grep '<li><b>' "$WIKI"  > "${WIKI}1"
sed -e 's/<a href[^>]*>//g;s/<li><b>//g;s@<i>@@g;s@</[^>]*>@@g' "${WIKI}1" > ${WIKI}2
grep '(.*)' ${WIKI}2 > ${WIKI}3
sed -f months.sed ${WIKI}3 > ${WIKI}4
sed '/:/{s/:[^(]*//;s/).*//};s/([^0-9-]*)//g' ${WIKI}4 > ${WIKI}5
cat ${WIKI}5|tr -d ". )'"|tr '(' ',' > ${WIKI}6
nl -s, -nln ${WIKI}6 |tr -d ' ' > ${WIKI}7

awk -F, -v OFS=, '{for (i=3;i<=NF;i++){print $1,$i;}}' ${WIKI}7|tr '-' ',' > dates.txt
awk -F, -v OFS=, '{print $1,$2;}' ${WIKI}7 > names.txt

