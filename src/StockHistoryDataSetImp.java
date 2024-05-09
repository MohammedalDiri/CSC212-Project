public class StockHistoryDataSetImp implements StockHistoryDataSet
{

    Map<String , StockHistory> SHDSI ; // IT'S A BST WITH THE COMPANY CODE AS KEY AND STOCK HISTORY AS VALUES
                                       // NOTE THAT SHDSI STANDS FOR StockHistoryDataSetImp
    public StockHistoryDataSetImp()
    {
        SHDSI = new BST<>() ;
    }

    @Override
    public int size()
    {
        return SHDSI.size(); //THIS WILL RETURN THE SIZE OF THE BST SHDSI
    }

    @Override
    public boolean empty()
    {
        return SHDSI.empty(); // BST EMPTY()
    }

    @Override
    public void clear()
    {
        SHDSI.clear(); // BST CLEAR()
    }

    @Override
    public Map<String, StockHistory> getStockHistoryMap()
    {
        if(SHDSI.empty())
            return null;

        return SHDSI;  // will return our StockHistoryDataSet
    }

    @Override
    public DLLComp<String> getAllCompanyCodes()
    {
        if(SHDSI.empty())
            return null;
        return SHDSI.getKeys() ;
    }
    public DLLImp<StockHistory> getAllCompanyStockHistory()
    {
        if(SHDSI.empty())
            return null;
        return SHDSI.getData() ;
    }

    @Override
    public StockHistory getStockHistory(String companyCode)
    {
        if(SHDSI.empty() || !SHDSI.find(companyCode))
            return null;
        return SHDSI.retrieve(); // when key is found the current will be on the right node so we just have to retrive the data
    }

    @Override
    public boolean addStockHistory(StockHistory StockHistory)
    {
        return SHDSI.insert(StockHistory.getCompanyCode(), StockHistory); // normal BST insert but we got the key from the StockHistory Provided
    }                                                                     // by using the method getCompanycode()

    @Override
    public boolean removeStockHistory(String companyCode)
    {
        return SHDSI.remove(companyCode) ; //BST Will handle the remove with all it cases
    }


    public boolean addStockHistoryByName(String name, StockHistory StockHistory) // EXTRA METHOD
    {
        return SHDSI.insert(name, StockHistory); //same insert as above but with name (We might need it later)
    }
}
