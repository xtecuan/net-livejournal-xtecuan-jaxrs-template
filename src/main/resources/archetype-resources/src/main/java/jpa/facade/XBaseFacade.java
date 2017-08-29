#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.jpa.facade;

/*
 * Copyright 2016 xtecuan.
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
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;

/**
 *
 * @author xtecuan
 */
public abstract class XBaseFacade {

    private static final Logger LOGGER = Logger.getLogger(XBaseFacade.class);

    protected abstract EntityManager getEntityManager();

    public static Logger getLogger() {
        return LOGGER;
    }

}
