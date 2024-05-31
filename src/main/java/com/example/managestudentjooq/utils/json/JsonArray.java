//package com.example.managestudentjooq.utils.json;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class JsonArray implements Iterable<Object>{
//    private List<Object> list;
//
//    public JsonArray(String json) {
//        fromJson(json);
//    }
//
//    private void fromJson(String json) {
//        list = Json.decodeValue(json, List.class);
//    }
//
//    public JsonArray(List list) {
//        this.list = list;
//    }
//
//    public List getList() {
//        return list;
//    }
//
//    @Override
//    public Iterator<Object> iterator() {
//        return null;
//    }
//
//    private class Iter implements Iterator<Object> {
//
//        final Iterator<Object> listIter;
//
//        Iter(Iterator<Object> listIter) {
//            this.listIter = listIter;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return listIter.hasNext();
//        }
//
//        @Override
//        public Object next() {
//            Object val = listIter.next();
//            if (val instanceof Map) {
//                val = new JsonObject((Map) val);
//            } else if (val instanceof List) {
//                val = new JsonArray((List) val);
//            }
//            return val;
//        }
//
//        @Override
//        public void remove() {
//            listIter.remove();
//        }
//    }
//}
