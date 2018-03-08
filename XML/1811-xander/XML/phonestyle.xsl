<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Phones</h1>
                <xsl:for-each select="phones/phone">
                    <h2><xsl:value-of select="model_simple"/></h2>
                    <p><xsl:value-of select="model_complex"/></p>
                    <p><xsl:value-of select="CPU_model"/></p>
                    <p><xsl:value-of select="RAM"/></p>
                    <p><xsl:value-of select="storage"/></p>
                    <p>&#8364;<xsl:value-of select="price"/></p>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>