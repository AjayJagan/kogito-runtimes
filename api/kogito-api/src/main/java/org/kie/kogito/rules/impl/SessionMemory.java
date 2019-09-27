/*
 * Copyright 2005 JBoss Inc
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

package org.kie.kogito.rules.impl;

import org.kie.kogito.rules.DataHandle;
import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnitMemory;

public class SessionMemory implements RuleUnitMemory {
    private final DataStore<Object> dataSource = DataSource.createStore();

    public DataSource<Object> getDataSource() {
        return dataSource;
    }

    public DataHandle add(Object obj) {
        return dataSource.add( obj );
    }

    public void remove(DataHandle dh) {
        dataSource.remove( dh );
    }

    public void update(DataHandle dh, Object obj) {
        dataSource.update( dh, obj );
    }
}