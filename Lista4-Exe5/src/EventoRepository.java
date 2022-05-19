import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventoRepository
{
	private static Map<String, Evento> items = new HashMap<>();

	public static boolean add(Evento evento)
	{
		if (exists(evento))
			return false;

		try
		{
			items.put(evento.getTitulo(), evento);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public static Evento get(String titulo)
	{
		return items.getOrDefault(titulo, null);
	}

	public static boolean update(Evento evento)
	{
		if (!exists(evento))
			return false;

		try
		{
			items.put(evento.getTitulo(), evento);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public static boolean exists(Evento evento)
	{
		return items.containsKey(evento.getTitulo());
	}

	public static ArrayList<Evento> getAll()
	{
		return new ArrayList<Evento>(items.values());
	}
}
