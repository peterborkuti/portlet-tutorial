# consumer-producer pattern in two different portlets

producer has service which is built with service-builder.
This portlet has a simple table with strings and the view.jsp has
a button with wich user can add new records to the table.

consumer has the producer's service in its lib (it automatically copied,
because the property *required-deployment-contexts=producer-036-00-portlet* is
set in liferay-plugin-package.properties. The portlet's view.jps uses the services
of producer portlet.

There is a similar example in the official Liferay tutorial, however, that uses one portlet project
with two portlets and becase the classloader is the same for both portlets, that is not a big deal.
However, if a portlet wants to use another portlet's service, they have different classloaders, so they
can not see each other's jar if required-deployment-context is not set.

[screenshot](screenshot.png)


