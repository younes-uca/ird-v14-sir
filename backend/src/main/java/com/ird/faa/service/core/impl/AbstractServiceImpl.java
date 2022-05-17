package com.ird.faa.service.core.impl;

import com.ird.faa.service.util.ListUtil;
import java.util.ArrayList;
import java.util.List;



public class AbstractServiceImpl<T> {

 public List<List<T>>  getToBeSavedAndToBeDeleted(List<T> oldList,List<T> newList){
                List<List<T>> result= new ArrayList<>();
                    List<T> resultDelete= new ArrayList<>();
                        List<T> resultUpdateOrSave= new ArrayList<>();
                            if (ListUtil.isEmpty(oldList) &&  ListUtil.isNotEmpty(newList)){
                            resultUpdateOrSave.addAll(newList);
                            }else if (ListUtil.isEmpty(newList) &&  ListUtil.isNotEmpty(oldList)){
                            resultDelete.addAll(oldList);
                            }else if(ListUtil.isNotEmpty(newList) &&  ListUtil.isNotEmpty(oldList)) {
                            for (int i = 0; i <oldList.size() ; i++) {
                            T myOld = oldList.get(i);
                            T t = newList.stream().filter(e -> myOld.equals(e)).findFirst().orElse(null);
                            if(t!=null){
                            resultUpdateOrSave.add(t);
                            }else{
                            resultDelete.add(myOld);
                            }
                            }
                            for (int i = 0; i <newList.size() ; i++) {
                            T myNew = newList.get(i);
                            T t = oldList.stream().filter(e -> myNew.equals(e)).findFirst().orElse(null);
                            if(t==null){
                            resultUpdateOrSave.add(myNew);
                            }
                            }
                            }
                            result.add(resultUpdateOrSave);
                            result.add(resultDelete);
                            return result;
                            }
}
