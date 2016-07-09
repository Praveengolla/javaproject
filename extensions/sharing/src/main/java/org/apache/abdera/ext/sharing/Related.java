/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 */
package org.apache.abdera.ext.sharing;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.ElementWrapper;

public class Related extends ElementWrapper {

    public static enum Type {
        COMPLETE, AGGREGATED
    };

    public Related(Element internal) {
        super(internal);
    }

    public Related(Factory factory, QName qname) {
        super(factory, qname);
    }

    public IRI getLink() {
        String link = getAttributeValue("link");
        return link != null ? new IRI(link) : null;
    }

    public void setLink(String link) {
        if (link != null) {
            setAttributeValue("link", new IRI(link).toString());
        } else {
            removeAttribute(new QName("link"));
        }
    }

    public String getTitle() {
        return getAttributeValue("title");
    }

    public void setTitle(String title) {
        if (title != null) {
            setAttributeValue("title", title);
        } else {
            removeAttribute(new QName("title"));
        }
    }

    public Type getType() {
        String type = getAttributeValue("type");
        return type != null ? Type.valueOf(type.toUpperCase()) : null;
    }

    public void setType(Type type) {
        if (type != null) {
            setAttributeValue("type", type.name().toLowerCase());
        } else {
            removeAttribute(new QName("type"));
        }
    }

}
