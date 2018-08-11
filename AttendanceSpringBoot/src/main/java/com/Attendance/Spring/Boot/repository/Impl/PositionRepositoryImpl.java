package com.Attendance.Spring.Boot.repository.Impl;

import com.Attendance.Spring.Boot.modal.Position;

import java.util.HashMap;
import java.util.Map;

public class PositionRepositoryImpl {
    private static PositionRepositoryImpl respository = null;

    private Map<String, Position> positionTable;

    private PositionRepositoryImpl() {
        positionTable = new HashMap<String, Position>();
    }

    public static PositionRepositoryImpl getInstance(){
        if(respository==null)
            respository = new PositionRepositoryImpl();
        return respository;
    }

    public Position create(Position position) {
        positionTable.put(position.getId(),position);
        Position savedPosition = positionTable.get(position.getId());
        return savedPosition;
    }

    public Position read(String id) {
        Position position = positionTable.get(id);
        return position;
    }

    public Position update(Position position) {
        positionTable.put(position.getId(),position);
        Position savedPosition = positionTable.get(position.getId());
        return savedPosition;
    }

    public void delete(String id) {
        positionTable.remove(id);

    }
}
