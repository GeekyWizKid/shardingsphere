/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.metadata.refresh;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import lombok.Getter;
import org.apache.shardingsphere.infra.metadata.model.ShardingSphereMetaData;
import org.apache.shardingsphere.infra.metadata.model.datasource.CachedDatabaseMetaData;
import org.apache.shardingsphere.infra.metadata.model.rule.RuleSchemaMetaData;
import org.apache.shardingsphere.infra.metadata.model.schema.model.column.ColumnMetaData;
import org.apache.shardingsphere.infra.metadata.model.schema.model.index.IndexMetaData;
import org.apache.shardingsphere.infra.metadata.model.schema.model.schema.SchemaMetaData;
import org.apache.shardingsphere.infra.metadata.model.schema.model.table.TableMetaData;
import org.junit.Before;

import java.util.Collections;

import static org.mockito.Mockito.mock;

@Getter
public abstract class AbstractMetaDataRefreshStrategyTest {
    
    private ShardingSphereMetaData metaData;
    
    @Before
    public void setUp() {
        metaData = buildMetaData();
    }
    
    private ShardingSphereMetaData buildMetaData() {
        SchemaMetaData schemaMetaData = new SchemaMetaData(ImmutableMap.of(
                "t_order", new TableMetaData(Collections.singletonList(new ColumnMetaData("order_id", 1, "String", false, false, false)), Collections.singletonList(new IndexMetaData("index")))));
        return new ShardingSphereMetaData(null, new RuleSchemaMetaData(schemaMetaData, ImmutableMap.of("t_order_item", Lists.newArrayList("t_order_item"))), mock(CachedDatabaseMetaData.class));
    }
}

