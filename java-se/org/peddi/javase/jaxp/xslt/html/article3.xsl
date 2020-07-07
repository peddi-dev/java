<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

    <xsl:output method="html"/>
    <xsl:strip-space elements="SECT"/>

<!--    <xsl:template match="text()">-->
<!--        <xsl:value-of select="normalize-space()"/>-->
<!--    </xsl:template>-->

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
    <xsl:template match="DEF">
        <i>
            <xsl:apply-templates/>
        </i>
    </xsl:template>

    <xsl:template match="B|I|U">
        <xsl:element name="{name()}">
            <xsl:apply-templates/>
        </xsl:element>
    </xsl:template>

    <xsl:template match="LINK">
        <xsl:if test="@target">
            <xsl:call-template name="htmllink">
                <xsl:with-param name="dest">
                   <xsl:value-of select="@target"/>
                </xsl:with-param>
            </xsl:call-template>
        </xsl:if>
        <xsl:if test="not(@target)">
            <xsl:call-template name="htmllink">
                <xsl:with-param name="dest">
                    <xsl:apply-templates/>
                </xsl:with-param>
            </xsl:call-template>
        </xsl:if>
    </xsl:template>
    <xsl:template name="htmllink">
        <xsl:param name="dest" select="UNDEFINED"/>
            
        <xsl:element name="a">
            <xsl:attribute name="href">
                <xsl:value-of select="$dest" />
            </xsl:attribute>
            <xsl:apply-templates/>
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>



