package org.apache.maven.wagon.proxy;

/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.wagon.WagonConstants;

import java.io.Serializable;

/**
 * Conatins set of properties used by <code>Wagon</code> objects
 * while connection to the repository must go thru a proxy server.
 * 
 * @author <a href="michal.maczka@dimatics.com">Michal Maczka</a>
 * @version $Id$
 * @todo Propose standard types of proxy servers (e.g. <i>SOCKSv4</i>),
 * which can be shared between wagon api and providers
 */
public class ProxyInfo implements Serializable
{

    /** Proxy server host */
    private String host = null;

    /** Username used to access the proxy server */
    private String userName = null;

    /** Password associated with the proxy server */
    private String password = null;

    /** Proxy server port */
    private int port = WagonConstants.UNKNOWN_PORT;


    /** Type of the proxy */
    private String type = null;


    /**
     * Return proxy server host name.
     * 
     * @return proxy server host name
     */
    public String getHost()
    {
        return host;
    }

    /**
     * Set proxy host name.
     * 
     * @param host proxy server host name
     */
    public void setHost( final String host )
    {
        this.host = host;
    }

    /**
     * Get user's password used to login to proxy server.
     * 
     * @return user's password at proxy host
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Set the user's password for the proxy server.
     * 
     * @param password password to use to login to a proxy server
     */
    public void setPassword( final String password )
    {
        this.password = password;
    }

    /**
     * Get the proxy port.
     * 
     * @return proxy server port
     */
    public int getPort()
    {
        return port;
    }

    /**
     * Set the proxy port.
     * 
     * @param port proxy server port
     */
    public void setPort( final int port )
    {
        this.port = port;
    }

    /**
     * Get the proxy username.
     * 
     * @return username for the proxy server
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * Set the proxy username.
     * 
     * @param userName username for the proxy server
     */
    public void setUserName( final String userName )
    {
        this.userName = userName;
    }


    /**
     * Get the type of the proxy server.
     * 
     * @return the type of the proxy server
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type the type of the proxy server like <i>SOCKSv4</i>
     */
    public void setType( final String type )
    {
        this.type = type;
    }

}
