/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2013 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.virtualization;

import java.io.IOException;
import java.util.UUID;

/**
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: UUIDSerializer.java 6168 2013-05-16 17:27:14Z lucianc $
 */
public class UUIDSerializer implements ObjectSerializer<UUID>
{
	@Override
	public int typeValue()
	{
		return SerializationConstants.OBJECT_TYPE_UUID;
	}

	@Override
	public ReferenceType defaultReferenceType()
	{
		return ReferenceType.OBJECT;
	}

	@Override
	public boolean defaultStoreReference()
	{
		return true;
	}

	@Override
	public void write(UUID value, VirtualizationOutput out) throws IOException
	{
		out.writeLong(value.getMostSignificantBits());
		out.writeLong(value.getLeastSignificantBits());
	}

	@Override
	public UUID read(VirtualizationInput in) throws IOException
	{
		long mostSigBits = in.readLong();
		long leastSigBits = in.readLong();
		return new UUID(mostSigBits, leastSigBits);
	}
}