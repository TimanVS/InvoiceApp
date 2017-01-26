package ua.timan.invoice.service;

import java.util.List;

import ua.timan.invoice.domain.PackingList;

public class PackingListService {

    public PackingList create(PackingList arg0) {
        // TODO: 1. add unique id
        return save(arg0);
    }

    public PackingList save(PackingList arg0) {
        // TODO: store to DB
        return arg0;
    }

    public PackingList get(String id) {
        return null;
    }

    public List<PackingList> getAll(long offset, long size, boolean asc) {
        return null;
    }

    public void delete(String id) {

    }

    public PackingList update(PackingList arg0) {
        PackingList value = get(arg0.getId());

        // TODO: Update fields except id with values from arg0.

        return save(value);
    }

}
