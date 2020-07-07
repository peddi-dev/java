<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

    <xsl:output method="html"/>
    <xsl:strip-space elements="SECT"/>

    <xsl:template match="text()">
        <xsl:value-of select="normalize-space()"/>
    </xsl:template>

    <xsl:template match="/">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/ARTICLE/TITLE">
        <h1 align="center">
            <xsl:apply-templates/>
        </h1>
    </xsl:template>

    <xsl:template match="/ARTICLE/TITLE/SECT">
        <h2>
            <xsl:apply-templates select="text()|B|I|U|DEF|LINK"/>
        </h2>
        <xsl:apply-templates select="SECT|PARA|LIST|NOTE"/>
    </xsl:template>

    <xsl:template match="/ARTICLE/TITLE/SECT/SECT">
        <h2>
            <xsl:apply-templates select="text()|B|I|U|DEF|LINK"/>
        </h2>
        <xsl:apply-templates select="SECT|PARA|LIST|NOTE"/>
    </xsl:template>

    <xsl:template match="/ARTICLE/TITLE/SECT/SEC">
        <xsl:message terminate="yes">
            Sections can only be nested 2 levels deep.
        </xsl:message>
    </xsl:template>

    <xsl:template match="PARA">
        <p>
            <xsl:apply-templates select="text()|B|I|U|DEF|LINK"/>
        </p>
     <xsl:apply-templates select="PARA|LIST|NOTE"/>
    </xsl:template>

    <xsl:template match="LIST">
        <xsl:if test="@type='ordered'">
            <ol>
            <xsl:apply-templates/>
            </ol>
        </xsl:if>

        <xsl:if test="@type='unordered'">
            <ul>
                <xsl:apply-templates/>
            </ul>
        </xsl:if>
    </xsl:template>

    <xsl:template match="ITEM">
        <li>
            <xsl:apply-templates/>
        </li>
    </xsl:template>

    <xsl:template match="NOTE">
        <blockquote>
        <b>Note:</b><br/>
        <p>
            <xsl:apply-templates/>
        </p>
        </blockquote>
    </xsl:template>

</xsl:stylesheet>



