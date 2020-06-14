/*******************************************************************************
 * Copyright (c) 2008, 2011 Sonatype Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sonatype Inc. - initial API and implementation
 *******************************************************************************/
package com.atlassian.connector.bundle;

import com.atlassian.connector.pomfirst.PomFirst;

public class ITP02 {

    public String getMessage() {
        return new PomFirst().getMessage();
    }

}
