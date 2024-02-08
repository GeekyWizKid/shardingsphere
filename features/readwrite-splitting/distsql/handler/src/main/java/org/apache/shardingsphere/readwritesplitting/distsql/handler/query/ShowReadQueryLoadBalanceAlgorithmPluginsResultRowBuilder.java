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

package org.apache.shardingsphere.readwritesplitting.distsql.handler.query;

import org.apache.shardingsphere.distsql.handler.engine.query.ral.plugin.PluginMetaDataQueryResultRows;
import org.apache.shardingsphere.distsql.handler.executor.ral.plugin.ShowPluginsResultRowBuilder;
import org.apache.shardingsphere.distsql.statement.ral.queryable.show.ShowPluginsStatement;
import org.apache.shardingsphere.infra.merge.result.impl.local.LocalDataQueryResultRow;
import org.apache.shardingsphere.readwritesplitting.spi.ReadQueryLoadBalanceAlgorithm;

import java.util.Collection;

/**
 * Show read query load balance algorithm plugins result row builder.
 */
public final class ShowReadQueryLoadBalanceAlgorithmPluginsResultRowBuilder implements ShowPluginsResultRowBuilder {
    
    private final PluginMetaDataQueryResultRows pluginMetaDataQueryResultRows = new PluginMetaDataQueryResultRows(ReadQueryLoadBalanceAlgorithm.class);
    
    @Override
    public Collection<LocalDataQueryResultRow> generateRows(final ShowPluginsStatement sqlStatement) {
        return pluginMetaDataQueryResultRows.getRows();
    }
    
    @Override
    public Collection<String> getColumnNames() {
        return pluginMetaDataQueryResultRows.getColumnNames();
    }
    
    @Override
    public String getType() {
        return "READ_QUERY_LOAD_BALANCE_ALGORITHM";
    }
}