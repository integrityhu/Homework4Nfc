/**
 * This file is part of NFC Tools Applet.
 * Copyright (c) 2012 by Adrian Stabiszewski, as@grundid.de
 *
 * Relation Analyzer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Relation Analyzer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Relation Analyzer.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.nfctools.tools.ndef;

import java.util.Map;

import org.nfctools.ndef.Record;
import org.nfctools.ndef.ext.AndroidApplicationRecord;

public class AndroidApplicationRecordBuilder implements Builder {

	@Override
	public boolean canHandle(String type) {
		return "androidApplicationRecord".equals(type);
	}

	@Override
	public Record convert(Map<String, String> data) {
		return new AndroidApplicationRecord(data.get("packageName"));
	}

	@Override
	public boolean canHandle(Record record) {
		return record instanceof AndroidApplicationRecord;
	}

	@Override
	public Map<String, String> convert(Record record) {
		return MapBuilder.map("type", "androidApplicationRecord", "packageName",
				((AndroidApplicationRecord)record).getPackageName());
	}

}
