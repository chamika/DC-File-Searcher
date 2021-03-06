package lk.ac.mrt.network;

import lk.ac.mrt.routing.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinu on 11/3/16.
 */
public class RegisterResponse extends Response {

    private int numberOfNodes;

    List<Node> nodeList = new ArrayList<Node>();


    public RegisterResponse() {
        this.type = ResponseType.REGISTER;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void setNumberOfNodes(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public List<Node> getNodeList(){ return nodeList; }


    @Override
    public String marshall() {
        //return appendAll(type.code(), getNumberOfNodes());
        return null;
    }

    @Override
    public void unmarshall(String messsageData) {
        String[] splits = messsageData.split(String.valueOf(WHITESPACE));
        int numOfNodes = Integer.parseInt(splits[1]);
		setNumberOfNodes(numOfNodes);
        if(numberOfNodes <=9900){
            for (int i = 0; i < numOfNodes ; i++) {
                int index = i*3;
                Node node = new Node(splits[index+2],Integer.parseInt(splits[index+3]));
                node.setNodeID(splits[index+4]);
                nodeList.add(node);
            }

        }

    }
}
