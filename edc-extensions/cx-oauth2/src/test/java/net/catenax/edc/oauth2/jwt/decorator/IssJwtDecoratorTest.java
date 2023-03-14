/*
 *  Copyright (c) 2022 Mercedes-Benz Tech Innovation GmbH
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Mercedes-Benz Tech Innovation GmbH - Initial Test
 *
 */

package net.catenax.edc.oauth2.jwt.decorator;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IssJwtDecoratorTest {

  @Test
  void decorate() {
    final String expectedIssuer = UUID.randomUUID().toString();
    final IssJwtDecorator decorator = new IssJwtDecorator(expectedIssuer);

    Assertions.assertTrue(decorator.claims().containsKey(JWTClaimNames.ISSUER));
    Assertions.assertEquals(expectedIssuer, decorator.claims().get(JWTClaimNames.ISSUER));
  }

  @Test
  void constructorNull() {
    Assertions.assertThrows(NullPointerException.class, () -> new IssJwtDecorator(null));
  }
}
