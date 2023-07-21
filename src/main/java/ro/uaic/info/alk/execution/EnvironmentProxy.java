package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.storage.LocationMapperIface;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.symbolic.ASTSimplifier;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class EnvironmentProxy
implements Environment
{
    protected Map<String, Location> variables = new HashMap<>();
    private final Environment target;
    private final StoreImpl store;

    public EnvironmentProxy(Environment e)
    {
        this.target = e;
        this.store = e.getStore();
    }

    public void addTempEntry(String id, Storable value)
    {
        if (variables.containsKey(id))
        {
            store.set(variables.get(id), value);
        }
        else
        {
            variables.put(id, store.malloc().setValue(value));
        }
    }

    @Override
    public Location getLocation(String id)
    {
        if (variables.containsKey(id))
        {
            return variables.get(id);
        }
        else
        {
            return target.getLocation(id);
        }
    }

    @Override
    public void setLocation(String name, Location location)
    {
        if (variables.containsKey(name))
        {
            variables.put(name, location);
        }
        else
        {
            target.setLocation(name, location);
        }
    }

    public Location define(String id)
    {
        return target.define(id);
    }

    @Override
    public void update(String id, Storable value)
    {
        if (variables.containsKey(id))
        {
            variables.get(id).setValue(value);
        }
        else
        {
            target.update(id, value);
        }
    }

    @Override
    public boolean has(String id)
    {
        return target.has(id) || variables.containsKey(id);
    }

    @Override
    public Environment clone(LocationMapper locMapping, StoreImpl store)
    {
        // TODO: this is a bug ... the target should be one that was already cloned
        EnvironmentProxy copyEnv = new EnvironmentProxy(target);
        for (Map.Entry<String, Location> entry : variables.entrySet())
        {
            copyEnv.variables.put(entry.getKey(), locMapping.get(entry.getValue()));
        }
        return copyEnv;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(target.toString());
        for (Map.Entry<String, Location> i : variables.entrySet())
        {
            Storable val = store.get(i.getValue());
            if (val instanceof SymbolicValue)
            {
                LocationMapperIface lm = loc -> loc;
                val = new SymbolicValue(((SymbolicValue) val).toAST().accept(new ASTSimplifier(lm, true)));
            }
            sb.append(i.getKey()).append(" |-> ").append(val).append('\n');
        }
        return sb.toString();
    }

    @Override
    public String toString(int padding)
    {
        // TODO put proper padding
        return target.toString();
    }

    @Override
    public Set<String> getVariables()
    {
        Set<String> vars = new HashSet<>(target.getVariables());
        vars.addAll(variables.keySet());
        return vars;
    }

    @Override
    public StoreImpl getStore()
    {
        return store;
    }
}
