package com.lyris.mesa.message.tx;

/**
 * Interface that represents Transaction context.
 * 
 * @author cveerapaneni
 * 
 */
public interface ITxContext {

    /**
     * Begins a transaction by either creating a new MessageContext object or retrieving an existing MessageContext object from the Hazelcast cache.
     */
    void beginTx();

    /**
     * Commits the transaction.
     */
    void commitTx();

    /**
     * Redelivers the transaction identifed by the messageContextId on the MessageContext object.
     */
    void redeliverTx();

}