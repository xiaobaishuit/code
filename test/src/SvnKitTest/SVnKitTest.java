package SvnKitTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class SVnKitTest {
	public static void main(String[] args) throws SVNException {
		//System.out.println("/1/2".);
		String url="svn://localhost";
		 String name="admin";
		 String password="admin";
		 SVNRepository repository = null;
		repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url));
	     ISVNAuthenticationManager authManager = 
	                  SVNWCUtil.createDefaultAuthenticationManager(name, password);
	     repository.setAuthenticationManager(authManager);
	     Collection entries = repository.getDir("/", -1, null,
	              (Collection) null);
	       Iterator iterator = entries.iterator();
	       int time = 4;
	       List<String> listTemp = new ArrayList<String>();
	       while (iterator.hasNext()) {
      			SVNDirEntry entry = (SVNDirEntry) iterator.next();
      			System.out.println(entry.getRepositoryRoot().toString());
      			listTemp.add( "/"+entry.getName());
      		}
	       Map<Integer,List<String>> mapTemp = new HashMap<Integer, List<String>>() ;
	       mapTemp.put(1, listTemp);
	       for(int i = 2;i<time;i++){
	    	   listTemp = new ArrayList<String>();
	    	   	for(String s : mapTemp.get(i-1)){
	    	   		Collection entriesTemp = repository.getDir("/"+s, -1, null,
	  	 	              (Collection) null);
	    	   		Iterator	iteratorTemp = entriesTemp.iterator();
	    	   			 while (iteratorTemp.hasNext()) {
	    	   				 SVNDirEntry entry = (SVNDirEntry) iteratorTemp.next();
	    	   				if (entry.getKind().toString().equals("file")) {
	    	   					continue;
	    	   				}
	       			listTemp.add(s+"/"+entry.getName());
	       		}
	    	   	}
	    	   	mapTemp.put(i, listTemp);
	       } 
	       for(int i=1;i<time;i++){
	    	   for(String s :mapTemp.get(i)){
	    		   System.out.println(s);
	    	   }
	       }
	       
	     //  giveAuthByInt("/rw/temp",4);
	       /*for(String s : temp){
	       			Collection entriesTemp = repository.getDir(s, -1, null,
	 	              (Collection) null);
	       		}
	       
	       
	       System.out.println(  entry.getCommitMessage());

	        System.out.println(  entry.getDate());

	        System.out.println(   entry.getKind().toString());


	      

	        System.out.println(  entry.getRepositoryRoot().toString());

	        System.out.println(  entry.getRevision());

	        System.out.println(    entry.getSize());

	        System.out.println(  entry.getName());

	        System.out.println(  entry.getAuthor());

		/*System.out.println(Thread.currentThread().getName());
		String path="[/1/2]";
		String tempString =  path.substring(1, path.length());
		System.out.println(tempString);*/
	}
	
	public static void giveAuthByInt(String path,int maxfloor) throws SVNException{
		int floorNum = getFloorNum(path);
		if(floorNum<maxfloor){
			String url="svn://localhost";
			 String name="admin";
			 String password="admin";
			 SVNRepository repository = null;
			repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url));
		     ISVNAuthenticationManager authManager = 
		                  SVNWCUtil.createDefaultAuthenticationManager(name, password);
		     repository.setAuthenticationManager(authManager);
		     Collection entries = repository.getDir(path, -1, null,
		              (Collection) null);
		       Iterator iterator = entries.iterator();
		       int time = 4;
		       List<String> listTemp = new ArrayList<String>();
		       while (iterator.hasNext()) {
	      			SVNDirEntry entry = (SVNDirEntry) iterator.next();
	      			listTemp.add( path+"/"+entry.getName());
	      		}
		       Map<Integer,List<String>> mapTemp = new HashMap<Integer, List<String>>() ;
		       mapTemp.put(floorNum+1, listTemp);
		       for(int i = floorNum+2;i<=maxfloor;i++){
		    	   listTemp = new ArrayList<String>();
		    	   	for(String s : mapTemp.get(i-1)){
		    	   	//	System.out.println(s);
		    	   		Collection entriesTemp = repository.getDir(s, -1, null,
		  	 	              (Collection) null);
		    	   		Iterator	iteratorTemp = entriesTemp.iterator();
		    	   			 while (iteratorTemp.hasNext()) {
		    	   				 SVNDirEntry entry = (SVNDirEntry) iteratorTemp.next();
		    	   				if (entry.getKind().toString().equals("file")) {
		    	   					continue;
		    	   				}
		       			listTemp.add(s+"/"+entry.getName());
		       		}
		    	   	}
		    	   	mapTemp.put(i, listTemp);
		       } 
		       for(int i = floorNum+1;i<=maxfloor;i++){
		    	   for(String s :mapTemp.get(i)){
		    		   System.out.println(s);
		    	   }
		       }
		}
	}
	
	public static int getFloorNum(String path){
		char[] charlist = path.toCharArray(); 
		int floorNum=0;
		for(int i =0; i<charlist.length;i++){
			if("/".equals(String.valueOf(charlist[i]))){
				floorNum++;
			}
		}
		return floorNum;
	}
}
