Public render parameters
========================

For public render parameters to work accross pages (and do not clear at page reloads) you need to set these
in your portal's portal-ext.properties file and restart portal:

```
    #
    # Set the default value for the "p_l_reset" parameter. If set to true,
    # render parameters are cleared when different pages are hit. This is not
    # the behavior promoted by the portlet specification, but is the one that
    # most end users seem to prefer.
    #
    layout.default.p_l_reset=false

    #
    # Set this property to specify how public render parameters are distributed.
    # If the value is "layout-set", then public render parameters will be
    # distributed to all portlets contained in a layout set. This will only work
    # correctly if the property "layout.default.p_l_reset" is set to false. If
    # the value is "layout", then public render parameters will be distributed
    # to all portlets that are present in a layout.
    #
    portlet.public.render.parameter.distribution=layout-set
```
