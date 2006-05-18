package org.drools.reteoo;
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



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.drools.FactException;
import org.drools.RuleBaseConfiguration;
import org.drools.spi.PropagationContext;

public class MockTupleSink extends TupleSource
    implements
    TupleSink,
    NodeMemory {
    private List asserted  = new ArrayList();
    private List retracted = new ArrayList();
    private List modified  = new ArrayList();

    public MockTupleSink() {
        super( 0 );
    }

    public MockTupleSink(int id) {
        super( id );
    }

    public void assertTuple(ReteTuple tuple,
                            PropagationContext context,
                            WorkingMemoryImpl workingMemory) {
        this.asserted.add( new Object[]{tuple, context, workingMemory} );

    }

    public void retractTuple(ReteTuple tuple,
                             PropagationContext context,
                             WorkingMemoryImpl workingMemory) {
        this.retracted.add( new Object[]{tuple, context, workingMemory} );

    }

    public void modifyTuple(ReteTuple tuple,
                            PropagationContext context,
                            WorkingMemoryImpl workingMemory) {
        this.modified.add( new Object[]{tuple, context, workingMemory} );
    }

    public List getAsserted() {
        return this.asserted;
    }

    public List getRetracted() {
        return this.retracted;
    }

    public List getModified() {
        return this.modified;
    }

    public void ruleAttached() {
        // TODO Auto-generated method stub
    }

    public void setHasMemory(boolean hasMemory) {
        this.hasMemory = hasMemory;
    }

    public int getId() {
        return this.id;
    }

    public Object createMemory( RuleBaseConfiguration config ) {
        return new HashMap();
    }

    public void attach() {
        // TODO Auto-generated method stub

    }

    public void updateNewNode(WorkingMemoryImpl workingMemory,
                              PropagationContext context) throws FactException {
        // TODO Auto-generated method stub

    }

    public void remove(BaseNode node,
                       WorkingMemoryImpl[] workingMemories) {
        // TODO Auto-generated method stub

    }

    public void attach(WorkingMemoryImpl[] workingMemories) {
        // TODO Auto-generated method stub

    }

    public List getPropagatedTuples(WorkingMemoryImpl workingMemory,
                                    TupleSink sink) {
        // TODO Auto-generated method stub
        return Collections.EMPTY_LIST;
    }

}