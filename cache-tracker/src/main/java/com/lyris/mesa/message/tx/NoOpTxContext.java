package com.lyris.mesa.message.tx;

/**
 * NoOp transaction context that does not do anything.
 * 
 * @author cveerapaneni
 * 
 */
public class NoOpTxContext implements ITxContext {

    @Override
    public void beginTx() {
    }

    @Override
    public void commitTx() {
    }

    @Override
    public void redeliverTx() {
    }

}
