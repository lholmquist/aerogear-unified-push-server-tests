/*
 * Copyright 2009, Mahmood Ali.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above
 *     copyright notice, this list of conditions and the following disclaimer
 *     in the documentation and/or other materials provided with the
 *     distribution.
 *   * Neither the name of Mahmood Ali. nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.notnoop.apns.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.notnoop.apns.ApnsService;

/**
 * 
 * This class mocks the original com.notnoop.apns.internal.ApnsServiceImpl class and is used for testing reasons.
 * 
 */
public class ApnsServiceImpl implements ApnsService {

    public ApnsServiceImpl() {

    }

    public static Collection<String> tokensList = null;

    public static String alert = null;

    public static String sound = null;

    public static int badge = -1;

    public void start() {
    }

    public void stop() {
    }

    public void testConnection() {

    }

    public Map<String, Date> getInactiveDevices() {
        return new HashMap<String, Date>();
    }

    @SuppressWarnings("rawtypes")
    public Collection push(Collection<String> tokens, String message) {
        if (tokens != null) {
            tokensList = new ArrayList<String>();
            tokensList.addAll(tokens);
        }

        if (message != null) {
            String[] parts = message.split(",");
            for (String part : parts) {
                String[] subparts = part.split(":");
                if ("alert".equals(subparts[0]))
                    alert = subparts[1];
                else if ("sound".equals(subparts[0]))
                    sound = subparts[1];
                else
                    badge = subparts[1] != null ? Integer.parseInt(subparts[1]) : -1;
            }
        }
        return null;
    }

    public static void clear() {
        tokensList = null;
        alert = null;
        sound = null;
        badge = -1;
    }
}