/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2012 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.batch.bootstrap;

import org.sonar.wsclient.connectors.Connector;
import org.sonar.wsclient.services.CreateQuery;
import org.sonar.wsclient.services.DeleteQuery;
import org.sonar.wsclient.services.Query;
import org.sonar.wsclient.services.UpdateQuery;

/**
 * @since 3.4
 */
public class WsConnector extends Connector {

  private ServerClient server;

  public WsConnector(ServerClient server) {
    this.server = server;
  }

  /**
   * @return JSON response or null if 404 NOT FOUND error
   * @throws org.sonar.wsclient.connectors.ConnectionException
   *          if connection error or HTTP status not in (200, 404)
   */
  @Override
  public String execute(Query<?> query) {
    return server.request(query.getUrl());
  }

  /**
   * @return JSON response or null if 404 NOT FOUND error
   * @since 2.2
   */
  @Override
  public String execute(CreateQuery<?> query) {
    throw new UnsupportedOperationException();
  }

  /**
   * @return JSON response or null if 404 NOT FOUND error
   * @since 2.2
   */
  @Override
  public String execute(DeleteQuery query) {
    throw new UnsupportedOperationException();
  }

  /**
   * @return JSON response or null if 404 NOT FOUND error
   * @since 2.6
   */
  @Override
  public String execute(UpdateQuery<?> query) {
    throw new UnsupportedOperationException();
  }
}
