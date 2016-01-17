# I forgot to add build.xml to git, so all of them lost

for p in *-portlet; do

echo $p
if [ "$p" != "preference2-portlet" ]; then
	cat buildxml-template.xml|sed -e "s/XXX/$p/g" > $p/build.xml
fi;



done